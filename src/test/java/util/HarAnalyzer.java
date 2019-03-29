package util;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HarAnalyzer {

    private final static Logger logger = LogManager.getLogger();

    public static List<HarRequest> getRequests(Har har, String urlPattern) {
        List<HarRequest> harEntryList = new ArrayList<>();
        for (HarEntry entry : har.getLog().getEntries()) {
            if (entry.getRequest() != null) {
                HarRequest request = entry.getRequest();
                String requestUrl = entry.getRequest().getUrl();
                if (requestUrl.contains(urlPattern)) {
                    harEntryList.add(request);
                }
            }
        }
        logger.info(harEntryList);
        return harEntryList;
    }
}
