/*
 * Copyright 2019, Imperva, Inc. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License Version 1.0, which accompanies this
 * distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Imperva, the Imperva logo, SecureSphere, Incapsula, CounterBreach,
 * ThreatRadar, Camouflage, Attack Analytics, Prevoty and design are trademarks
 * of Imperva, Inc. and its subsidiaries. All other brand or product names are
 * trademarks or registered trademarks of their respective holders.
 */

package org.sonatype.nexus.plugins.cargo.git.repo;

import java.io.IOException;

import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.RefUpdate.Result;

public class RefRename
        extends org.eclipse.jgit.lib.RefRename
{
    RefRename(RefUpdate src, RefUpdate dst) {
        super(src, dst);
    }

    @Override
    protected Result doRename() throws IOException {
        destination.setExpectedOldObjectId(ObjectId.zeroId());
        destination.setNewObjectId(source.getRef().getObjectId());
        switch (destination.update()) {
            case NEW:
                source.delete();
                return Result.RENAMED;

            default:
                return destination.getResult();
        }
    }
}
