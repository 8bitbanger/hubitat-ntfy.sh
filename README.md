Virtual driver to facilitate sending notifications to locally hosted or public ntfy.sh service. More information at https://ntfy.sh/. No affiliation. 

This driver was written primarily for use with the locally-hosted service however it does appear to work with the public ntfy.sh site (free). I only tested public service *briefly* before commiting. See notes below Re: settings. I have not tested any HTTPS, only HTTP.

I welcome pull requests - this was my first stab at a Hubitat driver and I only wrote it for personal use. Since I wish even this was available when I went looking initially, against my better judgement I'm posting it. 

It's crude, so use at your own risk! :)

Installation:
- Hubitat->Drivers Code->+New Driver, paste code, Save
- Hubitat->Devices->Add Device-> </> Virtual. Select Virtual ntfy-sh Notifier from drop-down, give name, Create.

Setup device by specifying path (hostname or IP) to ntfy server, port, and default message attributes (Title, Priority)
- To use self/locally hosted ntfy, only enter IP address or hostname (no proceeding http/https://) e.g. ntfy.myhouse.local. Match the port to what you're using.
- To use public nfty service, enter 'ntfy.sh' in address, port 80.

Usage:
From any Hubitat app that supports notification, simply select the virtual notifier created above. Specify message text.
Test message can be sent from the driver info page.
