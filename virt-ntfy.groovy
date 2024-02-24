/**
 * Driver:     Ntfy.sh Notification Driver
 * Author:     Jamie Kline (springboarded from sburke781)
 * Repository: https://github.com/8bitbanger/hubitat-ntfy.sh
 * Import URL: https://github.com/8bitbanger/hubitat-ntfy.sh/virt-ntfy.groovy
 * Change Log:
 *
 * 2024.02.23 - Initial Release
 * 2024.02.24 - Changed default preferences to be web-based ntfy.sh settings, default title.
 */

metadata {
	definition (name: "Virtual Ntfy-sh Notifier", namespace: "8bitbanger", author: "Jamie Kline" ) { 
        capability "Notification" 
    }
    
    preferences {
        input name: 'ipAddr',    // ntfy server hostname or address
                type: 'text',
                title: 'ntfy IP Address or hostname (exclude http/https://)',
                defaultValue: 'ntfy.sh'
                required: true
        input name: 'port',    
                type: 'text',
                title: 'port',
                defaultValue: '80'
                required: true
        input name: 'topic',
                type: 'text',
                title: 'Subscription Topic',
                required: true
        input name: 'title',     // optional title
                type: 'text',
                title: 'Notification Title',
                defaultValue: 'Hubitat'            
                required: false
        input ("priority", "enum", title: "Message Priority",
		defaultValue: "3",
		options: [5 : "Max",
			  4 : "High",
			  3 : "Default",
			  2 : "Low", 
			  1 : "Min"])
        input name: "logEnable", type: "bool", title: "Enable debug logging", defaultValue: true
        input name: "txtEnable", type: "bool", title: "Enable descriptionText logging", defaultValue: true
   }
}

void deviceNotification(String text) {

  def headers = [:];
  headers.put("Content-Type", "application/json");
  def bodyJson = "{\"topic\": \"${topic}\",\"title\": \"${title}\",\"priority\": ${priority},\"message\":\"${text}\"}";
  def postParams = [ 
        uri: "http://${ipAddr}:${port}",
        headers: headers,
        contentType: 'application/json',
        body : bodyJson
        ]
  if (logEnable) log.debug "postParams: ${postParams}"
  
  try {
        httpPost(postParams)
        { resp -> 
             if (logEnable) log.debug "deviceNotification: ${resp.data}"
        }

        }
        catch (Exception e) {
        log.warn "deviceNotification: Unable to send notification: ${e}"
        }
}
