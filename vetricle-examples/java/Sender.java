/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.platform.Verticle;

public class Sender extends Verticle {

  public void start() {
    // Publish some news on the feed every second

    vertx.setPeriodic(1000, new Handler<Long>() {
      @Override
      public void handle(Long timerID) {
        vertx.eventBus().publish("http://192.168.0.143/splanet/eventbus", "more news!");
      }
    });
  }
}
