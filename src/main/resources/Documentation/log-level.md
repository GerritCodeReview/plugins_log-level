@PLUGIN@
==============

NAME
----
@PLUGIN@ - Set log-levels on plug-in start-up

SYNOPSIS
--------
@PLUGIN@.properties:

```
com.google.gerrit.server.change.EmailReviewComments=FATAL
org.eclipse.jetty.server.session=WARN
com.google.gerrit.server.plugins=WARN
```

DESCRIPTION
-----------
Allows setting log-levels on plug-in start-up. The plug-in works similar to the
ssh `logging` command but allows setting log-levels permanently.
