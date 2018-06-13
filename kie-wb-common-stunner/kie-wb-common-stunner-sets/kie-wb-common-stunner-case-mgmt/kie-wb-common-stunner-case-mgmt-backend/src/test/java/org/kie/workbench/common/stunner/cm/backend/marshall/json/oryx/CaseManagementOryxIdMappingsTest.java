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
//
//package org.kie.workbench.common.stunner.cm.backend.marshall.json.oryx;
//
//import java.util.Map;
//import java.util.Set;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.kie.workbench.common.stunner.bpmn.backend.marshall.json.oryx.OryxIdMappings;
//import org.kie.workbench.common.stunner.cm.definition.CaseManagementDiagram;
//import org.kie.workbench.common.stunner.cm.definition.CaseManagementDiagramImpl;
//import org.kie.workbench.common.stunner.cm.definition.ReusableSubprocess;
//import org.kie.workbench.common.stunner.core.api.DefinitionManager;
//import org.mockito.Mock;
//
//import static org.junit.Assert.assertNotNull;
//
//public class CaseManagementOryxIdMappingsTest {
//
//    @Mock
//    private DefinitionManager definitionManager;
//
//    private OryxIdMappings oryxIdMappings;
//
//    @Before
//    public void setup() {
//        this.oryxIdMappings = new CaseManagementOryxIdMappings(definitionManager);
//    }
//
//    @Test
//    public void checkSkippedProperties() {
//        final Map<Class<?>, Set<String>> skippedProperties = oryxIdMappings.getSkippedProperties();
//        final Set<String> cmSkippedProperties = skippedProperties.get(CaseManagementDiagramImpl.class);
//        assertNotNull(cmSkippedProperties);
//    }
//
//    @Test
//    public void checkGetDefinitionMappingsForDiagram() {
//        assertDefinitionMappings(CaseManagementDiagram.class);
//    }
//
//    @Test
//    public void checkGetDefinitionMappingsForReusableSubprocess() {
//        assertDefinitionMappings(ReusableSubprocess.class);
//    }
//
//    private void assertDefinitionMappings(final Class cmClass) {
//        final Map<Class<?>, Map<Class<?>, String>> definitionMappings = oryxIdMappings.getDefinitionMappings();
//        final Map<Class<?>, String> cmDefinitionMappings = definitionMappings.get(cmClass);
//        assertNotNull(cmDefinitionMappings);
//    }
//}
