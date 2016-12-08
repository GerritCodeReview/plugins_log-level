// Copyright (C) 2017 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.googlesource.gerrit.plugins.loglevel;

import com.google.gerrit.extensions.events.LifecycleListener;
import com.google.gerrit.server.config.PluginConfigFactory;
import com.google.inject.Inject;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jgit.lib.Config;

public class LogLevel implements LifecycleListener {
  private static final Logger log =
      Logger.getLogger(LogLevel.class);

  private static final String CFG_NAME = "log-level";

  private static enum LevelOption {
    ALL,
    TRACE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    FATAL,
    OFF
  }

  @Inject
  private PluginConfigFactory configFactory;

  @Override
  public void start() {
    log.info("Plug-in started");
    Config config = configFactory.getGlobalPluginConfig(CFG_NAME);
    for (LevelOption level : LevelOption.values()) {
      String[] names = config.getStringList("log-levels", level.name(), "name");
      if (names != null) {
        log.info("Setting log levels to [" + level + "] ");
        for (String name : names) {
          Logger logger = Logger.getLogger(name);
          logger.setLevel(Level.toLevel(level.name()));
          log.info("[" + level + "] " + name);
        }
      }
    }
  }

  @Override
  public void stop() {
  }
}
