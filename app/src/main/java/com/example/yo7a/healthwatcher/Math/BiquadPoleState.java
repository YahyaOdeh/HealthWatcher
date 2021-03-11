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


import org.apache.commons.math3.complex.Complex;

/**
 * PoleZeroPair with gain factor
 */
public class BiquadPoleState extends PoleZeroPair {


    public BiquadPoleState(Complex p, Complex z) {
        super(p, z);
    }

    public BiquadPoleState(Complex p1, Complex z1,
                           Complex p2, Complex z2) {
        super(p1, z1, p2, z2);
    }

    double gain;

}
