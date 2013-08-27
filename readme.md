Use
===
This Plugin is designed to create a context event with a given String and return it as a ping.

It only answers configured context requests with the parameters action_type = ping and id with a string to returned.

Native App Usage
================
Add context support as follows:

```Java
dynamix.addContextSupport(dynamixCallback, "org.ambientdynamix.contextplugins.context.info.sample.ping");
```
    
Request Context by creating a Bundle

```Java
Bundle scanConfig = new Bundle();
scanconfig.putString("action_type", "ping");
scanconfig.putString("id", "someString");
dynamix.configuredContextRequest(dynamixCallback, "org.ambientdynamix.contextplugins.pingplugin", "org.ambientdynamix.contextplugins.context.info.sample.ping", scanConfig);
```    

Copyright
=========

Copyright (C) Institute of Telematics, Lukas Ruge

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.