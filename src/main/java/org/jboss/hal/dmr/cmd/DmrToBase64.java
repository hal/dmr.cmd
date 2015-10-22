/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.hal.dmr.cmd;

import org.jboss.dmr.ModelNode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Reads a textual DMR representation from stdin and prints the base64 encoded binary format to stdout.
 *
 * @author Harald Pehl
 */
public class DmrToBase64 {

    public static void main(String[] args) {
        try {
            ModelNode modelNode = ModelNode.fromStream(System.in);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            modelNode.writeExternal(bytes);
            System.out.println(Base64.getEncoder().encodeToString(bytes.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException("Unable to convert and encode DMR to Base64: " + e.getMessage());
        }
    }
}
