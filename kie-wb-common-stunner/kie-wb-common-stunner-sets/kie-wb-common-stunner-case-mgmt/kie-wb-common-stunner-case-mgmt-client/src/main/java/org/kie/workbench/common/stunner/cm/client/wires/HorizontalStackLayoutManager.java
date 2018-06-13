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
package org.kie.workbench.common.stunner.cm.client.wires;

import java.util.List;

import com.ait.lienzo.client.core.shape.wires.WiresContainer;
import com.ait.lienzo.client.core.shape.wires.WiresShape;
import com.ait.lienzo.client.core.types.Point2D;
import com.ait.tooling.nativetools.client.collection.NFastArrayList;

public class HorizontalStackLayoutManager extends AbstractNestedLayoutHandler {

    static final double PADDING_X = 25.0;
    static final double PADDING_Y = 25.0;

    @Override
    protected void orderChildren(final WiresShape shape,
                                 final WiresContainer container,
                                 final Point2D mouseRelativeLoc) {
        if (container == null) {
            return;
        }
        final double shapeX = mouseRelativeLoc.getX();

        final NFastArrayList<WiresShape> nChildren = container.getChildShapes().copy();
        final List<WiresShape> children = nChildren.remove(shape).toList();

        int targetIndex = children.size();

        for (int idx = 0; idx < children.size(); idx++) {
            final WiresShape child = children.get(idx);
            if (shapeX < child.getX()) {
                targetIndex = idx;
                break;
            }
        }

        if (container instanceof AbstractCaseManagementShape) {
            final int currentIndex = ((AbstractCaseManagementShape) container).getIndex(shape);
            if (currentIndex != targetIndex) {
                ((AbstractCaseManagementShape) container).addShape(shape,
                                                                   targetIndex);
            }
        }
    }

    @Override
    public void layout(final WiresContainer container) {
        double x = PADDING_X;
        boolean isFirstPadding = true; // leave room for overlaying palette
        for (WiresShape ws : container.getChildShapes()) {
            if (isFirstPadding) {
                x = 75;
                isFirstPadding = false;
            }
            ws.setLocation(new Point2D(x, PADDING_Y));
            x = x + ws.getPath().getBoundingBox().getWidth() + PADDING_X;
        }
    }
}
