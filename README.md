Virtual driver to facilitate sending notifications to local ntfy.sh service. More information at https://ntfy.sh/

This driver was written exclusively for the self-hosted LAN ntfy.sh service. I have only tested the web-based service via HTTP (not HTTPS) and only at a surface level (see notes below Re: settings)

I welcome pull requests - this was my first stab at a Hubitat driver and I only wrote it for personal use (still, I wish this was out there when I was looking for it, thus the reason I'm posting this).

It's crude, so use at your own risk! :)

Installation:
- Hubitat->Drivers Code->+New Driver, paste code, Save
- Hubitat->Devices->Add Device-> </> Virtual. Select Virtual ntfy-sh Notifier from drop-down, give name, Create.

Setup device by specifying path (hostname or IP) to ntfy server, port, and default message attributes (Title, Priority)
- To use self hosted nffy, only enter IP address or hostname (no proceeding http/https://) e.g. ntfy.myhouse.local. Match the port to what you're using.
- To use public nfty service, enter 'ntfy.sh' in address, port 80.

From any app that support notification, simply select the virtual notifier by name chosen above.
