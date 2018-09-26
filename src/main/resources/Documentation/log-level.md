@PLUGIN@
==============

NAME
----
@PLUGIN@ - Set log-levels on plug-in start-up

SYNOPSIS
--------
@PLUGIN@.config:

```
[FATAL]
    name = com.google.gerrit.server.change.EmailReviewComments

[WARN]
    name = org.eclipse.jetty.server.session
    name = com.google.gerrit.server.plugins
```

DESCRIPTION
-----------
Allows setting log-levels on plug-in start-up. The plug-in works similar to the
ssh `logging` command but allows setting log-levels permanently.
