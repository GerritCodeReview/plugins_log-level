load("//tools/bzl:plugin.bzl", "gerrit_plugin")

gerrit_plugin(
  name = 'log-level',
  srcs = glob(['src/main/java/**/*.java']),
  deps = ['//lib/log:log4j'],
  resources = glob(['src/main/resources/**/*']),
  manifest_entries = [
    'Gerrit-PluginName: log-level',
    'Gerrit-Module: com.googlesource.gerrit.plugins.loglevel.LogLevelModule',
    'Implementation-Title: Log Level plugin',
  ]
)
