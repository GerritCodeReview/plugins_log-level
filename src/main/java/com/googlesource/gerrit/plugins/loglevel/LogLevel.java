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

import com.google.gerrit.extensions.annotations.PluginName;
import com.google.gerrit.extensions.events.LifecycleListener;
import com.google.gerrit.server.config.SitePaths;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogLevel implements LifecycleListener {
  private static final Logger log = Logger.getLogger(LogLevel.class);

  @Inject private SitePaths sitePaths;
  @Inject private @PluginName String pluginName;

  @Override
  public void start() {
    log.info("Plug-in started");
    Properties config = new Properties();
    Path pluginConfig = sitePaths.etc_dir.resolve(pluginName + ".properties");
    try (InputStream in = Files.newInputStream(pluginConfig)) {
      config.load(in);
    } catch (NoSuchFileException e) {
      log.warn("Configuration file " + pluginConfig + " not found");
    } catch (IOException e) {
      log.error("Error loading config file " + pluginConfig, e);
    }

    for (String name : config.stringPropertyNames()) {
      String cfgLevel = config.getProperty(name);
      Logger logger = Logger.getLogger(name);
      Level level = Level.toLevel(cfgLevel, Level.INFO);
      logger.setLevel(level);
      log.info(name + "=" + level.toString());
    }
  }

  @Override
  public void stop() {}
}
