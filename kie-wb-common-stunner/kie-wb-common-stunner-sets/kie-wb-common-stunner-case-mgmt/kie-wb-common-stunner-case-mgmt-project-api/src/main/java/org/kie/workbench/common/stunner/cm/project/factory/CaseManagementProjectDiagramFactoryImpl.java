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
package org.kie.workbench.common.stunner.cm.project.factory;

import javax.enterprise.context.Dependent;

import org.guvnor.common.services.project.model.Package;
import org.kie.workbench.common.stunner.bpmn.BPMNDefinitionSet;
import org.kie.workbench.common.stunner.cm.definition.CaseManagementDiagram;
import org.kie.workbench.common.stunner.cm.definition.CaseManagementDiagramImpl;
import org.kie.workbench.common.stunner.cm.definition.general.DiagramSet;
import org.kie.workbench.common.stunner.cm.factory.AbstractCaseManagementDiagramFactory;
import org.kie.workbench.common.stunner.core.diagram.Metadata;
import org.kie.workbench.common.stunner.core.graph.Graph;
import org.kie.workbench.common.stunner.core.graph.Node;
import org.kie.workbench.common.stunner.core.graph.content.definition.Definition;
import org.kie.workbench.common.stunner.core.graph.content.definition.DefinitionSet;
import org.kie.workbench.common.stunner.project.diagram.ProjectDiagram;
import org.kie.workbench.common.stunner.project.diagram.ProjectMetadata;
import org.kie.workbench.common.stunner.project.diagram.impl.ProjectDiagramImpl;

@Dependent
public class CaseManagementProjectDiagramFactoryImpl extends AbstractCaseManagementDiagramFactory<ProjectMetadata, ProjectDiagram>
        implements CaseManagementProjectDiagramFactory {

    public CaseManagementProjectDiagramFactoryImpl() {
        setDiagramType(CaseManagementDiagramImpl.class);
    }

    @Override
    public Class<? extends Metadata> getMetadataType() {
        return ProjectMetadata.class;
    }

    @Override
    protected Class<?> getDefinitionSetType() {
        return BPMNDefinitionSet.class;
    }

    @Override
    public ProjectDiagram doBuild(final String name,
                                  final ProjectMetadata metadata,
                                  final Graph<DefinitionSet, ?> graph) {
        return new ProjectDiagramImpl(name,
                                      graph,
                                      metadata);
    }

    @Override
    protected void updateDiagramProperties(final String name,
                                           final Node<Definition<CaseManagementDiagram>, ?> diagramNode,
                                           final ProjectMetadata metadata) {
        super.updateDiagramProperties(name,
                                      diagramNode,
                                      metadata);
        // Set kie related properties for the current project.
        final CaseManagementDiagram diagram = diagramNode.getContent().getDefinition();
        final DiagramSet diagramSet = diagram.getDiagramSet();
        final String id = diagramSet.getId().getValue();
        if (id == null || id.isEmpty()) {
            final String projectName = null != metadata.getModuleName() ? metadata.getModuleName() + "." : "";
            diagramSet.getId().setValue(projectName + name);
        }
        final String p = diagramSet.getPackageProperty().getValue();
        if (p == null || p.isEmpty()) {
            final Package metadataPackage = metadata.getProjectPackage();
            final String value = metadataPackage == null ?
                    org.kie.workbench.common.stunner.bpmn.definition.property.diagram.Package.DEFAULT_PACKAGE :
                    metadata.getProjectPackage().getPackageName();
            diagramSet.getPackageProperty().setValue(value);
        }
        final String diagramName = diagramSet.getName().getValue();
        if (null == diagramName || diagramName.isEmpty()) {
            diagramSet.getName().setValue(name);
        }
    }
}
