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

package org.kie.workbench.common.stunner.cm.factory;

import java.util.function.Function;

import org.kie.workbench.common.stunner.cm.definition.CaseManagementDiagram;
import org.kie.workbench.common.stunner.core.diagram.Diagram;
import org.kie.workbench.common.stunner.core.diagram.Metadata;
import org.kie.workbench.common.stunner.core.factory.impl.BindableDiagramFactory;
import org.kie.workbench.common.stunner.core.graph.Graph;
import org.kie.workbench.common.stunner.core.graph.Node;
import org.kie.workbench.common.stunner.core.graph.content.definition.Definition;
import org.kie.workbench.common.stunner.core.graph.content.definition.DefinitionSet;
import org.kie.workbench.common.stunner.core.graph.util.GraphUtils;

public abstract class AbstractCaseManagementDiagramFactory<M extends Metadata, D extends Diagram<Graph, M>>
        extends BindableDiagramFactory<M, D> {

    private Class<? extends CaseManagementDiagram> diagramType;

    protected abstract D doBuild(final String name,
                                 final M metadata,
                                 final Graph<DefinitionSet, ?> graph);

    public void setDiagramType(final Class<? extends CaseManagementDiagram> diagramType) {
        this.diagramType = diagramType;
    }

    @Override
    public D build(final String name,
                   final M metadata,
                   final Graph<DefinitionSet, ?> graph) {
        final D diagram = doBuild(name,
                                  metadata,
                                  graph);
        final Node<Definition<CaseManagementDiagram>, ?> diagramNode = diagramProvider.apply(graph);
        if (null == diagramNode) {
            throw new IllegalStateException("A Case Mgmt Diagram is expected to be present on CM Diagram graphs.");
        }
        updateProperties(name,
                         diagramNode,
                         metadata);
        return diagram;
    }

    protected void updateDiagramProperties(final String name,
                                           final Node<Definition<CaseManagementDiagram>, ?> diagramNode,
                                           final M metadata) {
        // For additional initializations.
    }

    private void updateProperties(final String name,
                                  final Node<Definition<CaseManagementDiagram>, ?> diagramNode,
                                  final M metadata) {
        // Set the diagram node as the canvas root.
        metadata.setCanvasRootUUID(diagramNode.getUUID());
        // Delegate to subtypes.
        updateDiagramProperties(name,
                                diagramNode,
                                metadata);
    }

    @SuppressWarnings("unchecked")
    Function<Graph, Node<Definition<CaseManagementDiagram>, ?>> diagramProvider =
            graph -> GraphUtils.getFirstNode(graph,
                                             diagramType);
}
