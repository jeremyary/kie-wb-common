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

package org.kie.workbench.common.stunner.core.backend.definition.adapter.reflect;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.workbench.common.stunner.core.backend.definition.adapter.FooTestBean;
import org.kie.workbench.common.stunner.core.factory.graph.ElementFactory;
import org.kie.workbench.common.stunner.core.factory.graph.NodeFactory;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BackendDefinitionAdapterTest extends AbstractBackendAdapterTest {

    private static final String FOO1_VALUE = "foo1";
    private static final String FOO2_VALUE = "foo2";

    private BackendDefinitionAdapter<Object> tested;
    private FooTestBean instance;

    @Before
    public void setup() {
        super.setup();
        instance = new FooTestBean(FOO1_VALUE,
                                   FOO2_VALUE);
        final Set p = new HashSet<Object>() {{
            add(instance.fooPropertySet.fooProperty);
        }};
        tested = new BackendDefinitionAdapter<>(utils);
        when(utils.getPropertiesFromPropertySets(eq(instance))).thenReturn(p);
        when(adapterManager.forDefinition()).thenReturn(tested);
    }

    @Test
    public void testGetId() {
        final String id = tested.getId(instance);
        assertEquals(FooTestBean.class.getName(), id);
    }

    @Test
    public void testGetCategory() {
        final String category = tested.getCategory(instance);
        assertEquals(FooTestBean.CATEGORY, category);
    }

    @Test
    public void testGetTitle() {
        final String title = tested.getTitle(instance);
        assertEquals(FooTestBean.TITLE, title);
    }

    @Test
    public void testGetDescription() {
        final String description = tested.getDescription(instance);
        assertEquals(FooTestBean.DESCRIPTION, description);
    }

    @Test
    public void testGetLabels() {
        final Set<String> labels = tested.getLabels(instance);
        assertEquals(FooTestBean.LABELS, labels);
    }

    @Test
    public void testGraphFactory() {
        final Class<? extends ElementFactory> graphFactoryType = tested.getGraphFactoryType(instance);
        assertEquals(NodeFactory.class, graphFactoryType);
    }

    @Test
    public void testGetPropertySets() {
        final Set<?> propertySets = tested.getPropertySets(instance);
        assertEquals(1, propertySets.size());
        assertEquals(instance.fooPropertySet, propertySets.iterator().next());
    }

    @Test
    public void testGetProperties() {
        final Set<?> properties = tested.getProperties(instance);
        assertEquals(2, properties.size());
        assertTrue(properties.contains(instance.fooProperty));
        assertTrue(properties.contains(instance.fooPropertySet.fooProperty));
    }
}
