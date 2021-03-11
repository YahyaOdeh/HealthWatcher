/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *  Copyright (c) 2009 by Vinnie Falco
 *  Copyright (c) 2016 by Bernd Porr
 */

package com.example.yo7a.healthwatcher.Math;

/**
 * Implementation of a Direct Form II filter with its states. The coefficients
 * are supplied from the outside.
 */

public class DirectFormII extends DirectFormAbstract {

    public DirectFormII() {
        reset();
    }

    public void reset() {
        m_v1 = 0;
        m_v2 = 0;
    }

    public double process1(double in,
                           Biquad s) {
        if (s != null) {
            double w = in - s.m_a1 * m_v1 - s.m_a2 * m_v2;
            double out = s.m_b0 * w + s.m_b1 * m_v1 + s.m_b2 * m_v2;

            m_v2 = m_v1;
            m_v1 = w;

            return out;
        } else {
            return in;
        }
    }

    double m_v1; // v[-1]
    double m_v2; // v[-2]
}
