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
//package org.kie.workbench.common.stunner.cm.definition;
//
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class HashCodeAndEqualityTest {
//
//    @Test
//    public void testCaseManagementDiagramEquals() {
//        CaseManagementDiagramImpl a = new CaseManagementDiagram();
//        CaseManagementDiagram b = new CaseManagementDiagram();
//        assertEquals(a,
//                     b);
//        assertFalse(a.equals(19));
//        assertFalse(a.equals(null));
//    }
//
//    @Test
//    public void testCaseManagementDiagramHashCode() {
//        CaseManagementDiagramImpl a = new CaseManagementDiagramImpl();
//        CaseManagementDiagram b = new CaseManagementDiagram();
//        assertTrue(a.hashCode() == b.hashCode());
//    }
//
//    @Test
//    public void testReusableSubprocessEquals() {
//        ReusableSubprocess a = new ReusableSubprocess();
//        ReusableSubprocess b = new ReusableSubprocess();
//        assertFalse(a.equals(19));
//        assertFalse(a.equals(null));
//        assertEquals(a,
//                     b);
//    }
//
//    @Test
//    public void testReusableSubprocessHashCode() {
//        ReusableSubprocess a = new ReusableSubprocess();
//        ReusableSubprocess b = new ReusableSubprocess();
//        assertTrue(a.hashCode() - b.hashCode() == 0);
//    }
//}
