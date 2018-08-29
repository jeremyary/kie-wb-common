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

package org.kie.workbench.common.stunner.cm.client.canvas.controls.containment;

import com.ait.lienzo.test.LienzoMockitoTestRunner;
import org.junit.runner.RunWith;

@RunWith(LienzoMockitoTestRunner.class)
public class CaseManagementContainmentAcceptorControlImplTest {

//    public static final String PARENT_UUID = "parent1";
//    public static final String CANDIDATE_UUID = "candidate1";
//
//    @Mock
//    private AbstractCanvas canvas;
//
//    @Mock
//    private CaseManagementCanvasView canvasView;
//
//    @Mock
//    private CaseManagementCanvasHandler canvasHandler;
//
//    @Mock
//    private Index graphIndex;
//
//    @Mock
//    private CaseManagementCanvasCommandFactory canvasCommandFactory;
//
//    @Mock
//    private RequiresCommandManager.CommandManagerProvider<AbstractCanvasHandler> commandManagerProvider;
//
//    @Mock
//    private CanvasCommandManager<AbstractCanvasHandler> commandManager;
//
//    @Mock
//    private Node parent;
//
//    @Mock
//    private Node candidate;
//
//    @Mock
//    private Edge<Child, Node> childEdge;
//
//    @Mock
//    private CaseManagementSetChildCommand setChildCommand;
//
//    @Mock
//    private CaseManagementRemoveChildCommand removeChildCommand;
//
//    @Captor
//    private ArgumentCaptor<IContainmentAcceptor> containmentAcceptorArgumentCaptor;
//
//    private CaseManagementContainmentStateHolder state;
//
//    private CaseManagementContainmentAcceptorControlImpl control;
//
//    @Before
//    public void setup() {
//        this.state = new CaseManagementContainmentStateHolder();
//        this.control = new CaseManagementContainmentAcceptorControlImpl(canvasCommandFactory,
//                                                                        state);
//        this.control.setCommandManagerProvider(commandManagerProvider);
//
//        when(commandManagerProvider.getCommandManager()).thenReturn(commandManager);
//        when(canvasHandler.getAbstractCanvas()).thenReturn(canvas);
//        when(canvasHandler.getGraphIndex()).thenReturn(graphIndex);
//        when(canvas.getView()).thenReturn(canvasView);
//        when(graphIndex.getNode(eq(PARENT_UUID))).thenReturn(parent);
//        when(graphIndex.getNode(eq(CANDIDATE_UUID))).thenReturn(candidate);
//        when(parent.getUUID()).thenReturn(PARENT_UUID);
//        when(parent.getOutEdges()).thenReturn(Collections.singletonList(childEdge));
//        when(candidate.getUUID()).thenReturn(CANDIDATE_UUID);
//        when(candidate.getInEdges()).thenReturn(Collections.singletonList(childEdge));
//        when(childEdge.getContent()).thenReturn(new Child());
//        when(childEdge.getSourceNode()).thenReturn(parent);
//        when(childEdge.getTargetNode()).thenReturn(candidate);
//        when(canvasCommandFactory.setChildNode(any(Node.class),
//                                               any(Node.class))).thenReturn(setChildCommand);
//        when(canvasCommandFactory.removeChild(any(Node.class),
//                                              any(Node.class))).thenReturn(removeChildCommand);
//        when(commandManager.allow(eq(canvasHandler),
//                                  eq(setChildCommand))).thenReturn(CanvasCommandResultBuilder.SUCCESS);
//        when(commandManager.allow(eq(canvasHandler),
//                                  eq(removeChildCommand))).thenReturn(CanvasCommandResultBuilder.SUCCESS);
//        when(commandManager.execute(eq(canvasHandler),
//                                    eq(setChildCommand))).thenReturn(CanvasCommandResultBuilder.SUCCESS);
//        when(commandManager.execute(eq(canvasHandler),
//                                    eq(removeChildCommand))).thenReturn(CanvasCommandResultBuilder.SUCCESS);
//    }
//
//    @Test
//    public void checkDoInit() {
//        control.onInit(canvasView);
//
//        final IContainmentAcceptor containmentAcceptor = getContainmentAcceptor();
//        assertNotNull(containmentAcceptor);
//        assertTrue(containmentAcceptor instanceof CaseManagementContainmentAcceptorControlImpl.CanvasManagementContainmentAcceptor);
//    }
//
//    private IContainmentAcceptor getContainmentAcceptor() {
//        verify(canvasView,
//               times(1)).setContainmentAcceptor(containmentAcceptorArgumentCaptor.capture());
//        final IContainmentAcceptor containmentAcceptor = containmentAcceptorArgumentCaptor.getValue();
//        return containmentAcceptor;
//    }
//
//    @Test
//    public void getAddEdgeCommand() {
//        final Node parent = mock(Node.class);
//        final Node child = mock(Node.class);
//
//        control.getAddEdgeCommand(parent,
//                                  child);
//
//        verify(canvasCommandFactory,
//               times(1)).setChildNode(eq(parent),
//                                      eq(child));
//    }
//
//    @Test
//    public void getSetEdgeCommand() {
//        final Node parent = mock(Node.class);
//        final Node child = mock(Node.class);
//
//        control.getSetEdgeCommand(parent,
//                                  child,
//                                  Optional.empty(),
//                                  Optional.empty(),
//                                  Optional.empty());
//
//        verify(canvasCommandFactory,
//               times(1)).setChildNode(eq(parent),
//                                      eq(child),
//                                      eq(Optional.empty()),
//                                      eq(Optional.empty()),
//                                      eq(Optional.empty()));
//    }
//
//    @Test
//    public void getDeleteEdgeCommand() {
//        final Node parent = mock(Node.class);
//        final Node child = mock(Node.class);
//
//        control.getDeleteEdgeCommand(parent,
//                                     child);
//
//        verify(canvasCommandFactory,
//               times(1)).removeChild(eq(parent),
//                                     eq(child));
//    }
//
//    @Test
//    public void checkContainmentAllowed() {
//        control.init(canvasHandler);
//
//        final IContainmentAcceptor containmentAcceptor = getContainmentAcceptor();
//        final WiresShape parentShape = makeWiresShape(PARENT_UUID);
//        final WiresShape childShape = makeWiresShape(CANDIDATE_UUID);
//
//        assertTrue(containmentAcceptor.containmentAllowed(parentShape,
//                                                          new WiresShape[]{childShape}));
//        verify(canvasCommandFactory,
//               times(1)).removeChild(any(Node.class),
//                                     any(Node.class));
//        verify(canvasCommandFactory,
//               times(1)).setChildNode(any(Node.class),
//                                      any(Node.class));
//    }
//
//    private WiresShape makeWiresShape() {
//        return makeWiresShape(Optional.empty());
//    }
//
//    private MockCaseManagementShapeView makeWiresShape(String uuid) {
//        return makeWiresShape(Optional.of(uuid));
//    }
//
//    private MockCaseManagementShapeView makeWiresShape(Optional<String> uuid) {
//        final MockCaseManagementShapeView shape = new MockCaseManagementShapeView();
//        uuid.ifPresent(shape::setUUID);
//        WiresUtils.assertShapeGroup(shape.getGroup(),
//                                    WiresCanvas.WIRES_CANVAS_GROUP_ID);
//        return shape;
//    }
//
//    @Test
//    public void testAcceptContainment() {
//        control.init(canvasHandler);
//        final WiresShape parentShape = makeWiresShape(PARENT_UUID);
//        final WiresShape childShape = makeWiresShape(CANDIDATE_UUID);
//        final MockCaseManagementShapeView ghost = makeWiresShape(CANDIDATE_UUID);
//        state.setGhost(Optional.of(ghost));
//        final boolean isAccept =
//                control.CONTAINMENT_ACCEPTOR.acceptContainment(parentShape,
//                                                               new WiresShape[]{childShape});
//        assertTrue(isAccept);
//        verify(canvasCommandFactory,
//               times(1)).setChildNode(any(Node.class),
//                                      any(Node.class),
//                                      eq(Optional.of(0)),
//                                      eq(Optional.empty()),
//                                      eq(Optional.empty()));
//    }
//
//    private ILayoutHandler getILayoutHandler(final WiresContainer parentShape,
//                                             final WiresShape childShape) {
//        final IContainmentAcceptor containmentAcceptor = getContainmentAcceptor();
//
//        containmentAcceptor.acceptContainment(parentShape,
//                                              new WiresShape[]{childShape});
//        return parentShape.getLayoutHandler();
//    }
//
//    @Test
//    public void checkInterceptingLayoutHandlerRemove() {
//        control.init(canvasHandler);
//
//        final WiresShape parentShape = makeWiresShape();
//        final WiresShape childShape = makeWiresShape();
//        final ILayoutHandler layoutHandler = getILayoutHandler(parentShape,
//                                                               childShape);
//
//        layoutHandler.remove(childShape,
//                             parentShape);
//
//        assertTrue(parentShape.getLayoutHandler() instanceof ILayoutHandler.DefaultLayoutHandler);
//    }
}
