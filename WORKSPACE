workspace(name = "log_level")

load("//:bazlets.bzl", "load_bazlets")

load_bazlets(
    commit = "4293943826c5c1a42d39d772008106e4e02836cd",
    #local_path = "/home/<user>/projects/bazlets",
)

load(
    "@com_googlesource_gerrit_bazlets//:gerrit_api.bzl",
    "gerrit_api",
)

gerrit_api()
