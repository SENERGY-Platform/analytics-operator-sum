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

import com.jayway.jsonpath.JsonPath;
import junit.framework.TestCase;
import org.infai.ses.senergy.operators.Builder;
import org.infai.ses.senergy.operators.Message;
import org.infai.ses.senergy.testing.utils.JSONFileReader;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.Test;


public class ValueSumTest extends TestCase {

    static ValueSum valueSum;
    static JSONArray messages = new JSONFileReader().parseFile("messages.json");;
    static String configString;

    @Override
    protected void setUp() throws Exception {
        valueSum = new ValueSum();
    }

    @Test
    public void testSingleDeviceId(){
        configString = new JSONFileReader().parseFile("config-1.json").toString();
        Builder builder = new Builder("1", "1");
        Message message = new Message();
        message.setConfig(configString);
        valueSum.setConfig(configString);
        valueSum.configMessage(message);
        for(Object msg : messages){
            message.setMessage(builder.formatMessage(msg.toString()));
            valueSum.run(message);
        }
        Assert.assertEquals(new Double(5.0), JsonPath.parse(message.getMessageString()).read("$.analytics.sum"));
    }

    @Test
    public void testTwoDeviceIds(){
        configString = new JSONFileReader().parseFile("config-2.json").toString();
        Builder builder = new Builder("1", "1");
        Message message = new Message();
        message.setConfig(configString);
        valueSum.setConfig(configString);
        valueSum.configMessage(message);
        for(Object msg : messages){
            message.setMessage(builder.formatMessage(msg.toString()));
            valueSum.run(message);
        }
        Assert.assertEquals(new Double(10.0), JsonPath.parse(message.getMessageString()).read("$.analytics.sum"));
    }

    @Override
    protected void tearDown(){

    }
}
