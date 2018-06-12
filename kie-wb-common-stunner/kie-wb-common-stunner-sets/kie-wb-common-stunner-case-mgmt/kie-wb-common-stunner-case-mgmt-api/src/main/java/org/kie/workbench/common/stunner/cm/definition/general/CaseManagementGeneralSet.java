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

package org.kie.workbench.common.stunner.cm.definition.general;

import java.util.Objects;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.kie.workbench.common.forms.adf.definitions.annotations.FormDefinition;
import org.kie.workbench.common.forms.adf.definitions.annotations.FormField;
import org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textArea.type.TextAreaFieldType;
import org.kie.workbench.common.stunner.bpmn.definition.property.general.Documentation;
import org.kie.workbench.common.stunner.bpmn.definition.property.general.Name;
import org.kie.workbench.common.stunner.core.definition.annotation.Property;
import org.kie.workbench.common.stunner.core.definition.annotation.PropertySet;
import org.kie.workbench.common.stunner.core.util.HashUtil;

@Portable
@Bindable
@PropertySet
@FormDefinition(
        startElement = "name"
)
public class CaseManagementGeneralSet implements CaseManagementPropertySet,
                                                 CaseManagementBaseInfo {

    @Property
    @FormField(type = TextAreaFieldType.class)
    private Name name;

    @Property
    @FormField(
            type = TextAreaFieldType.class,
            afterElement = "name"
    )
    private Documentation documentation;

    public CaseManagementGeneralSet() {
        this(new Name(""),
             new Documentation());
    }

    public CaseManagementGeneralSet(final @MapsTo("name") Name name,
                                    final @MapsTo("documentation") Documentation documentation) {
        this.name = name;
        this.documentation = documentation;
    }

    public CaseManagementGeneralSet(final String name,
                                    final String documentation) {
        this.name = new Name(name);
        this.documentation = new Documentation(documentation);
    }

    public CaseManagementGeneralSet(String name) {
        this.name = new Name(name);
        this.documentation = new Documentation();
    }

    @Override
    public Name getName() {
        return name;
    }

    public void setName(final Name name) {
        this.name = name;
    }

    @Override
    public Documentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(final Documentation documentation) {
        this.documentation = documentation;
    }

    @Override
    public int hashCode() {
        return HashUtil.combineHashCodes(Objects.hashCode(name),
                                         Objects.hashCode(documentation));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseManagementGeneralSet) {
            CaseManagementGeneralSet other = (CaseManagementGeneralSet) o;
            return Objects.equals(name,
                                  other.name) &&
                    Objects.equals(documentation,
                                   other.documentation);
        }
        return false;
    }
}
