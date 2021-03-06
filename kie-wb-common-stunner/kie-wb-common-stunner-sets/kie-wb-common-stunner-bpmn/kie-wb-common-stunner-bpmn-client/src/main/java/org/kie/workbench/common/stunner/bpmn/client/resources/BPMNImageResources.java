/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.stunner.bpmn.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundleWithLookup;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface BPMNImageResources extends ClientBundleWithLookup {

    BPMNImageResources INSTANCE = GWT.create(BPMNImageResources.class);

    // ****** BPMN ShapeSet Thumbnail. *******
    @Source("images/bpmn_thumb.png")
    DataResource bpmnSetThumb();

    // ******* Categories *******
    @ClientBundle.Source("images/categories/activity.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryActivity();

    @ClientBundle.Source("images/categories/sub-process.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categorySubProcess();

    @ClientBundle.Source("images/categories/container.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryContainer();

    @ClientBundle.Source("images/categories/gateway.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryGateway();

    @ClientBundle.Source("images/categories/start-events.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryStartEvents();

    @ClientBundle.Source("images/categories/intermediate-events.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryIntermediateEvents();

    @ClientBundle.Source("images/categories/end-events.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryEndEvents();

    @ClientBundle.Source("images/categories/library.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryLibrary();

    @ClientBundle.Source("images/categories/sequence.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categorySequence();

    @ClientBundle.Source("images/categories/service-tasks.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource categoryServiceTasks();

    // ******* Task *******
    @ClientBundle.Source("images/icons/task/task.png")
    ImageResource task();

    @ClientBundle.Source("images/icons/task/task-user.png")
    ImageResource taskUser();

    @ClientBundle.Source("images/icons/task/task-script.png")
    ImageResource taskScript();

    @ClientBundle.Source("images/icons/task/task-business-rule.png")
    ImageResource taskBusinessRule();

    @ClientBundle.Source("images/icons/task/task-manual.png")
    ImageResource taskManual();

    @ClientBundle.Source("images/icons/task/task-service.png")
    ImageResource taskService();

    // ******* Event *******
    @ClientBundle.Source("images/icons/event/event-end.png")
    ImageResource eventEnd();

    @ClientBundle.Source("images/icons/event/event-end-none.png")
    ImageResource eventEndNone();

    @ClientBundle.Source("images/icons/event/event-end-signal.png")
    ImageResource eventEndSignal();

    @ClientBundle.Source("images/icons/event/event-end-message.png")
    ImageResource eventEndMessage();

    @ClientBundle.Source("images/icons/event/event-end-terminate.png")
    ImageResource eventEndTerminate();

    @ClientBundle.Source("images/icons/event/event-end-error.png")
    ImageResource eventEndError();

    @ClientBundle.Source("images/icons/event/event-intermediate-message.png")
    ImageResource eventIntermediateMessage();

    @ClientBundle.Source("images/icons/event/event-intermediate-error.png")
    ImageResource eventIntermediateError();

    @ClientBundle.Source("images/icons/event/event-intermediate-timer.png")
    ImageResource eventIntermediateTimer();

    @ClientBundle.Source("images/icons/event/event-intermediate-signal.png")
    ImageResource eventIntermediateSignal();

    @ClientBundle.Source("images/icons/event/event-intermediate-signal-throwing.png")
    ImageResource eventIntermediateSignalThrowing();

    @ClientBundle.Source("images/icons/event/event-intermediate-message-throwing.png")
    ImageResource eventIntermediateMessageThrowing();

    @ClientBundle.Source("images/icons/event/event-start-none.png")
    ImageResource eventStartNone();

    @ClientBundle.Source("images/icons/event/event-start-error.png")
    ImageResource eventStartError();

    @ClientBundle.Source("images/icons/event/event-start-signal.png")
    ImageResource eventStartSignal();

    @ClientBundle.Source("images/icons/event/event-start-message.png")
    ImageResource eventStartMessage();

    @ClientBundle.Source("images/icons/event/event-start-timer.png")
    ImageResource eventStartTimer();

    // ******* Gateway *******
    @ClientBundle.Source("images/icons/gateway/parallel-event.png")
    ImageResource gatewayParallelEvent();

    @ClientBundle.Source("images/icons/gateway/parallel-multiple.png")
    ImageResource gatewayParallelMultiple();

    @ClientBundle.Source("images/icons/gateway/exclusive.png")
    ImageResource gatewayExclusive();

    @ClientBundle.Source("images/icons/gateway/complex.png")
    ImageResource gatewayComplex();

    @ClientBundle.Source("images/icons/gateway/event.png")
    ImageResource gatewayEvent();

    @ClientBundle.Source("images/icons/gateway/inclusive.png")
    ImageResource gatewayInclusive();

    // ******* Containers *******

    @ClientBundle.Source("images/icons/lane_icon.png")
    ImageResource lane();

    // ******* Subprocesses *******
    @ClientBundle.Source("images/icons/subprocess/subprocess.svg")
    @DataResource.MimeType("image/svg+xml")
    DataResource subProcess();

    @ClientBundle.Source("images/icons/subprocess/subprocess-reusable.png")
    ImageResource subProcessReusable();

    @ClientBundle.Source("images/icons/subprocess/subprocess-adhoc.png")
    ImageResource subProcessAdHoc();

    @ClientBundle.Source("images/icons/subprocess/subprocess-event.png")
    ImageResource subProcessEvent();

    @ClientBundle.Source("images/icons/subprocess/subprocess-embedded.png")
    ImageResource subProcessEmbedded();

    @ClientBundle.Source("images/icons/subprocess/subprocess-multiple-instance.png")
    ImageResource subProcessMultipleInstance();

    // ******* Connectors *******

    @ClientBundle.Source("images/icons/connectors/sequence.png")
    ImageResource sequenceFlow();

    // ******* Misc *******

    @ClientBundle.Source("images/icons/default-service-node-icon.png")
    ImageResource serviceNodeIcon();

    //This is a hack for OOME related to SVG, or image/svg+xml;base64 URLs
    @Source("images/glyph-oome-hack.png")
    ImageResource glyphOOMEHack();
}
