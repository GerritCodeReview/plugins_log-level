workspace(name = "log_level")

load("//:bazlets.bzl", "load_bazlets")

load_bazlets(
    commit = "d044cd60d37e302d9ac324f7a2c4e48b4011d4e6",
    #local_path = "/home/<user>/projects/bazlets",
)

#Snapshot Plugin API
#load(
#    "@com_googlesource_gerrit_bazlets//:gerrit_api_maven_local.bzl",
#    "gerrit_api_maven_local",
#)

# Load snapshot Plugin API
#gerrit_api_maven_local()

# Release Plugin API
load(
    "@com_googlesource_gerrit_bazlets//:gerrit_api.bzl",
    "gerrit_api",
)

# Load release Plugin API
gerrit_api()