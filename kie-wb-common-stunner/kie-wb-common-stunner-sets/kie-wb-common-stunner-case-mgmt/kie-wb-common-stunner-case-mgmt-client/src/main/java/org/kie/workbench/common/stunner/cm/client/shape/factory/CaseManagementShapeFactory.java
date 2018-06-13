/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.stunner.cm.client.shape.factory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import org.kie.workbench.common.stunner.bpmn.definition.StartNoneEvent;
import org.kie.workbench.common.stunner.cm.client.shape.def.CaseManagementDiagramShapeDef;
import org.kie.workbench.common.stunner.cm.client.shape.def.HumanTaskShapeDef;
import org.kie.workbench.common.stunner.cm.client.shape.def.StageShapeDef;
import org.kie.workbench.common.stunner.cm.client.shape.def.SubcaseShapeDef;
import org.kie.workbench.common.stunner.cm.client.shape.def.SubprocessShapeDef;
import org.kie.workbench.common.stunner.cm.definition.CaseManagementDiagramImpl;
import org.kie.workbench.common.stunner.cm.definition.HumanTask;
import org.kie.workbench.common.stunner.cm.definition.Stage;
import org.kie.workbench.common.stunner.cm.definition.Subcase;
import org.kie.workbench.common.stunner.cm.definition.Subprocess;
import org.kie.workbench.common.stunner.cm.definition.general.CaseManagmentDefinition;
import org.kie.workbench.common.stunner.core.client.shape.Shape;
import org.kie.workbench.common.stunner.core.client.shape.factory.DelegateShapeFactory;
import org.kie.workbench.common.stunner.core.client.shape.factory.ShapeFactory;
import org.kie.workbench.common.stunner.core.definition.shape.Glyph;
import org.kie.workbench.common.stunner.shapes.client.factory.BasicShapesFactory;
import org.kie.workbench.common.stunner.svg.client.shape.factory.SVGShapeFactory;

@Dependent
public class CaseManagementShapeFactory implements ShapeFactory<CaseManagmentDefinition, Shape> {

    private final BasicShapesFactory basicShapesFactory;
    private final SVGShapeFactory svgShapeFactory;
    private final DelegateShapeFactory<CaseManagmentDefinition, Shape> delegateShapeFactory;

    @Inject
    public CaseManagementShapeFactory(final SVGShapeFactory svgShapeFactory,
                                      final BasicShapesFactory basicShapesFactory,
                                      final DelegateShapeFactory<CaseManagmentDefinition, Shape> delegateShapeFactory) {
        this.svgShapeFactory = svgShapeFactory;
        this.basicShapesFactory = basicShapesFactory;
        this.delegateShapeFactory = delegateShapeFactory;
    }

    @PostConstruct
    public void init() {
        delegateShapeFactory
                .delegate(CaseManagementDiagramImpl.class,
                          new CaseManagementDiagramShapeDef(),
                          () -> svgShapeFactory)
                .delegate(Stage.class,
                          new StageShapeDef(),
                          () -> svgShapeFactory)
                .delegate(HumanTask.class,
                          new HumanTaskShapeDef(),
                          () -> svgShapeFactory)
                .delegate(Subprocess.class,
                          new SubprocessShapeDef(),
                          () -> svgShapeFactory)
                .delegate(Subcase.class,
                          new SubcaseShapeDef(),
                          () -> svgShapeFactory);
                .delegate(StartNoneEvent.class,
                          new NullShapeDef(),
//                          () -> svgShapeFactory)
//                .delegate(ParallelGateway.class,
//                          new NullShapeDef(),
//                          () -> svgShapeFactory)
//                .delegate(ExclusiveGateway.class,
//                          new NullShapeDef(),
//                          () -> svgShapeFactory)
//                .delegate(Lane.class,
//                          new NullShapeDef(),
//                          () -> svgShapeFactory)
//                .delegate(EndTerminateEvent.class,
//                          new NullShapeDef(),
//                          () -> svgShapeFactory)
//                .delegate(EndNoneEvent.class,
//                          new NullShapeDef(),
//                          () -> svgShapeFactory)
//                .delegate(SequenceFlow.class,
//                          new SequenceFlowConnectorDef(),
//                          () -> basicShapesFactory);
    }

    @Override
    public Shape newShape(final CaseManagmentDefinition definition) {
        return delegateShapeFactory.newShape(definition);
    }

    @Override
    public Glyph getGlyph(final String definitionId) {
        GWT.log("definitionId: " + definitionId);
        return delegateShapeFactory.getGlyph(definitionId);
    }
}
