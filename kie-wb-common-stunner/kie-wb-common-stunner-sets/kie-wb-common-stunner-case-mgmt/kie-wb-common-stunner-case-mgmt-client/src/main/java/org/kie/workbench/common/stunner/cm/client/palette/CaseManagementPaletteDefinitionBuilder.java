/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.stunner.cm.client.palette;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.kie.workbench.common.stunner.bpmn.qualifiers.BPMN;
import org.kie.workbench.common.stunner.cm.client.resources.CaseManagementImageResources;
import org.kie.workbench.common.stunner.cm.definition.CaseManagementDiagramImpl;
import org.kie.workbench.common.stunner.cm.definition.HumanTask;
import org.kie.workbench.common.stunner.cm.definition.Stage;
import org.kie.workbench.common.stunner.cm.definition.StripLane;
import org.kie.workbench.common.stunner.cm.definition.Subcase;
import org.kie.workbench.common.stunner.cm.definition.Subprocess;
import org.kie.workbench.common.stunner.cm.definition.general.CaseManagementCategories;
import org.kie.workbench.common.stunner.core.client.canvas.AbstractCanvasHandler;
import org.kie.workbench.common.stunner.core.client.components.palette.DefaultPaletteDefinition;
import org.kie.workbench.common.stunner.core.client.components.palette.DefaultPaletteDefinitionProviders;
import org.kie.workbench.common.stunner.core.client.components.palette.ExpandedPaletteDefinitionBuilder;
import org.kie.workbench.common.stunner.core.client.components.palette.PaletteDefinitionBuilder;
import org.kie.workbench.common.stunner.core.client.shape.SvgDataUriGlyph;
import org.kie.workbench.common.stunner.core.i18n.StunnerTranslationService;

import static org.kie.workbench.common.stunner.core.client.components.palette.DefaultPaletteDefinitionProviders.isType;

@Dependent
@BPMN
public class CaseManagementPaletteDefinitionBuilder
        implements PaletteDefinitionBuilder<AbstractCanvasHandler, DefaultPaletteDefinition> {

    private static final DefaultPaletteDefinitionProviders.CategoryDefinitionProvider CATEGORY_DEFINITION =
            new DefaultPaletteDefinitionProviders.CategoryDefinitionProvider(CaseManagementCategories.class)

                    .put(CaseManagementCategories.STAGE,
                         category -> category
                                 .bindToDefinition(Stage.class)
                                 .useGlyph(SvgDataUriGlyph.Builder.build(
                                         CaseManagementImageResources.INSTANCE.stage().getSafeUri())))

                    .put(CaseManagementCategories.TASK,
                         category -> category
                                 .bindToDefinition(HumanTask.class)
                                 .useGlyph(SvgDataUriGlyph.Builder.build(
                                         CaseManagementImageResources.INSTANCE.userTask().getSafeUri())))

                    .put(CaseManagementCategories.SUBPROCESS,
                         category -> category
                                 .bindToDefinition(Subprocess.class)
                                 .useGlyph(SvgDataUriGlyph.Builder.build(
                                         CaseManagementImageResources.INSTANCE.subprocess().getSafeUri())))

                    .put(CaseManagementCategories.SUBCASE,
                         category -> category
                                 .bindToDefinition(Subcase.class)
                                 .useGlyph(SvgDataUriGlyph.Builder.build(
                                         CaseManagementImageResources.INSTANCE.subcase().getSafeUri())));

    //palette categories order customization.
    private static final List<String> CATEGORIES_ORDER = new ArrayList<String>() {
        {
            add(CaseManagementCategories.STAGE);
            add(CaseManagementCategories.TASK);
            add(CaseManagementCategories.SUBPROCESS);
            add(CaseManagementCategories.SUBCASE);
        }
    };

    // lane/containers type of custom group not required in CM just yet
    private static final Map<String, String> CUSTOM_GROUPS = new HashMap<>();

    private final ExpandedPaletteDefinitionBuilder paletteDefinitionBuilder;
    private final StunnerTranslationService translationService;

    // CDI proxy.
    protected CaseManagementPaletteDefinitionBuilder() {
        this(null,
             null);
    }

    @Inject
    public CaseManagementPaletteDefinitionBuilder(final ExpandedPaletteDefinitionBuilder paletteDefinitionBuilder,
                                                  final StunnerTranslationService translationService) {
        this.paletteDefinitionBuilder = paletteDefinitionBuilder;
        this.translationService = translationService;
    }

    @PostConstruct
    public void init() {
        paletteDefinitionBuilder
                .itemFilter(isDefinitionAllowed())
                .categoryFilter(category -> !CaseManagementCategories.CONTAINERS.equals(category))
                .categoryDefinitionIdProvider(CATEGORY_DEFINITION.definitionIdProvider())
                .categoryGlyphProvider(CATEGORY_DEFINITION.glyphProvider())
                .categoryMessages(CATEGORY_DEFINITION.categoryMessageProvider(translationService))
                .customGroupIdProvider(CUSTOM_GROUPS::get)
                .customGroupMessages(new DefaultPaletteDefinitionProviders.DefaultCustomGroupMessageProvider(translationService));
    }

    @Override
    public void build(final AbstractCanvasHandler canvasHandler,
                      final Consumer<DefaultPaletteDefinition> paletteDefinitionConsumer) {
        paletteDefinitionBuilder
                .build(canvasHandler,
                       paletteDefinition -> {
                           paletteDefinition
                                   .getItems()
                                   .sort(Comparator.comparingInt(item -> getCategoryOrder(item.getId())));
                       });
    }

    private int getCategoryOrder(final String categoryId) {
        return CATEGORIES_ORDER.indexOf(categoryId);
    }

    ExpandedPaletteDefinitionBuilder getPaletteDefinitionBuilder() {
        return paletteDefinitionBuilder;
    }

    private Predicate<String> isDefinitionAllowed() {
        return isType(CaseManagementDiagramImpl.class)
                .or(isType(StripLane.class))
                .negate();
    }
}
