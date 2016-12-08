@PLUGIN@
==============

NAME
----
@PLUGIN@ - Set log-levels on plug-in start-up

SYNOPSIS
--------
@PLUGIN@.config:
```
[log-level "FATAL"]
    name = com.google.gerrit.server.change.EmailReviewComments

[log-level "INFO"]
    name = com.google.gerrit.common.Version
```

DESCRIPTION
-----------
Allows setting log-levels on plug-in start-up. The plug-in works similar to the
ssh `logging` command but allows setting log-levels permanently.
