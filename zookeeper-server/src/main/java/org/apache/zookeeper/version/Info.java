/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zookeeper.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Info {

    private static final String KEY_MAVEN_VERSION = "maven.version";
    private static final String KEY_MAVEN_QUALIFIER = "maven.qualifier";
    private static final String KEY_VERSION_MAJOR = "version.major";
    private static final String KEY_VERSION_MINOR = "version.minor";
    private static final String KEY_VERSION_INCREMENTAL = "version.incremental";
    private static final String KEY_COMMIT_ID = "commit.id";
    private static final String KEY_BUILD_TIME = "build.time";

    static {
        final Properties properties = new Properties();
        try (final InputStream stream = Info.class.getClassLoader().getResourceAsStream("version.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            System.err.printf("Unable to load project properties, using default values: %s%n", e.getMessage());
        }
        VERSION = properties.getProperty(KEY_MAVEN_VERSION);
        MAJOR = Integer.parseInt(properties.getProperty(KEY_VERSION_MAJOR, "-1"));
        MINOR = Integer.parseInt(properties.getProperty(KEY_VERSION_MINOR, "-1"));
        MICRO = Integer.parseInt(properties.getProperty(KEY_VERSION_INCREMENTAL, "-1"));
        QUALIFIER = properties.getProperty(KEY_MAVEN_QUALIFIER);
        REVISION_HASH = properties.getProperty(KEY_COMMIT_ID);
        BUILD_DATE = properties.getProperty(KEY_BUILD_TIME);
    }

    public static final String VERSION;
    public static final int MAJOR;
    public static final int MINOR;
    public static final int MICRO;
    public static final String QUALIFIER;
    public static final int REVISION = -1; //@deprecated, please use REVISION_HASH
    public static final String REVISION_HASH;
    public static final String BUILD_DATE;
}
