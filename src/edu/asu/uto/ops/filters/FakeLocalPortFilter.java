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

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FakeLocalPortFilter implements Filter {
    private int localPort;

    public void init(FilterConfig config) throws ServletException {
        String port = config.getInitParameter("port");
        localPort = Integer.parseInt(port);
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        FakeLocalPortWrapper fakereq = new FakeLocalPortWrapper(request);
        fakereq.fake_setPort(localPort);
        chain.doFilter(fakereq, res);
    }

    public void destroy() {
    }
}
