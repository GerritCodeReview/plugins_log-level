workspace(name = "log_level")

load("//:bazlets.bzl", "load_bazlets")

load_bazlets(
    commit = "2629e3802493a45cdc7a3e03deb3331743daa09c",
    #local_path = "/home/<user>/projects/bazlets",
)

load(
    "@com_googlesource_gerrit_bazlets//:gerrit_api.bzl",
    "gerrit_api",
)

# Load release Plugin API
gerrit_api()

# Load snapshot Plugin API
#gerrit_api(version = "3.0.xy-SNAPSHOT")
