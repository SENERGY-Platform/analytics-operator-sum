/*
 * Copyright 2018 InfAI (CC SES)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.infai.seits.sepl.operators.Message;
import org.infai.seits.sepl.operators.OperatorInterface;

public class ValueSum implements OperatorInterface {

    private static Double currentValue = 0.0;

    @Override
    public void run(Message message) {
        currentValue += message.getInput("value").getValue();
        message.output("sum", (Math.round(currentValue * 1000.0) / 1000.0));
    }

    @Override
    public void config(Message message) {
        message.addInput("value");
    }
}
