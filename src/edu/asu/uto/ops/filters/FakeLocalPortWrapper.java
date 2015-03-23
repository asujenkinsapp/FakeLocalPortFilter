/*
Copyright 2015 Jesse DeFer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package edu.asu.uto.ops.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FakeLocalPortWrapper extends HttpServletRequestWrapper {
    private int localPort = 80;

    public FakeLocalPortWrapper(HttpServletRequest request) {
        super(request);
    }

    public int getLocalPort() {
        return localPort;
    }

    public void fake_setPort(int port) {
        localPort = port;
    }
}
