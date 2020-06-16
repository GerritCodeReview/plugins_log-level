workspace(name = "log_level")

load("//:bazlets.bzl", "load_bazlets")

load_bazlets(
    commit = "5c26af9e0374ede4cd67939be972adf6c4cda791",
    #local_path = "/home/<user>/projects/bazlets",
)

load(
    "@com_googlesource_gerrit_bazlets//:gerrit_api.bzl",
    "gerrit_api",
)

# Load release Plugin API
gerrit_api()

# Load snapshot Plugin API
#gerrit_api(version = "3.1.xy-SNAPSHOT")
