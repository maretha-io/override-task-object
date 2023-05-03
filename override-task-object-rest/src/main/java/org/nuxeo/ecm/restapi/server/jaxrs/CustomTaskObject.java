package org.nuxeo.ecm.restapi.server.jaxrs;


import java.util.List;

import javax.ws.rs.GET;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.platform.routing.api.DocumentRoutingService;
import org.nuxeo.ecm.restapi.server.jaxrs.routing.TaskObject;
import org.nuxeo.ecm.webengine.model.WebObject;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.ecm.platform.task.Task;
import org.nuxeo.ecm.platform.task.TaskConstants;



@WebObject(type = "task")
public class CustomTaskObject extends TaskObject {
    
    private static final Log log = LogFactory.getLog(CustomTaskObject.class);

@Override
@GET
public List<Task> getUserRelatedWorkflowTasks() {
    log.error("TaskObject HTTP(Get) task/ being called");
    if (StringUtils.isNotBlank(workflowModelName)) {
        return Framework.getService(DocumentRoutingService.class).getTasks(null, userId, workflowInstanceId,
                workflowModelName, getContext().getCoreSession());
    } else {
        return getPaginableEntries();
    }
}
}
