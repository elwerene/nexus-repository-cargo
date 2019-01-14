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

package org.sonatype.nexus.plugins.cargo;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.sonatype.nexus.plugins.cargo.git.repo.Repository;
import org.sonatype.nexus.repository.Facet;
import org.sonatype.nexus.repository.Facet.Exposed;

@Exposed
public interface GitRepositoryFacet
        extends Facet
{
    @Nonnull
    public Repository createGitRepository(String name) throws IOException;

    @Nullable
    public Repository getGitRepository(String name) throws IOException;

    public void replaceFile(Repository repository, String branch, String entryPath, byte[] bytes)
            throws IOException;
}
