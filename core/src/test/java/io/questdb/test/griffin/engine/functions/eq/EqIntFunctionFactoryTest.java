/*******************************************************************************
 *     ___                  _   ____  ____
 *    / _ \ _   _  ___  ___| |_|  _ \| __ )
 *   | | | | | | |/ _ \/ __| __| | | |  _ \
 *   | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *    \__\_\\__,_|\___||___/\__|____/|____/
 *
 *  Copyright (c) 2014-2019 Appsicle
 *  Copyright (c) 2019-2024 QuestDB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package io.questdb.test.griffin.engine.functions.eq;

import io.questdb.griffin.FunctionFactory;
import io.questdb.griffin.engine.functions.eq.EqIntFunctionFactory;
import io.questdb.std.Numbers;
import io.questdb.test.griffin.engine.AbstractFunctionFactoryTest;
import org.junit.Test;

public class EqIntFunctionFactoryTest extends AbstractFunctionFactoryTest {

    @Test
    public void testAll() throws Exception {
        assertMemoryLeak(() -> {
            call(10, 20).andAssert(false);
            call(150, 150).andAssert(true);
            call(Numbers.INT_NULL, 77).andAssert(false);
            call(77, Numbers.INT_NULL).andAssert(false);
        });
    }

    @Test
    public void testNullEqualsNull() throws Exception {
        assertMemoryLeak(() -> call(Numbers.INT_NULL, Numbers.INT_NULL).andAssert(true));
    }

    @Override
    protected FunctionFactory getFunctionFactory() {
        return new EqIntFunctionFactory();
    }
}
