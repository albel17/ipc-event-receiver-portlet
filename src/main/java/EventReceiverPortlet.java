import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ProcessEvent;

import com.liferay.util.bridges.mvc.MVCPortlet;

public class EventReceiverPortlet extends MVCPortlet {

    @ProcessEvent(qname = "{http://proliferay.com/events}ipc-text")
    public void myEvent(EventRequest request, EventResponse response) {
        System.out.println("Get data.");
        Event event = request.getEvent();
        //Get data from the event
        String sampleText = (String) event.getValue();
        //Set the text in response to display in UI
        response.setRenderParameter("sampleText", sampleText);
    }

}
