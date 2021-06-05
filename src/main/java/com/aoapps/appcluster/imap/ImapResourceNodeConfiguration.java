/*
 * ao-appcluster-imap - Application-level clustering tools for IMAP account replication.
 * Copyright (C) 2011, 2016, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-appcluster-imap.
 *
 * ao-appcluster-imap is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-appcluster-imap is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-appcluster-imap.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoapps.appcluster.imap;

import com.aoapps.appcluster.AppClusterConfigurationException;
import com.aoapps.appcluster.CronResourceNodeConfiguration;
import com.aoapps.appcluster.Node;

/**
 * The configuration for an IMAP inbox.
 *
 * @author  AO Industries, Inc.
 */
public interface ImapResourceNodeConfiguration extends CronResourceNodeConfiguration<ImapResource, ImapResourceNode> {

	@Override
	ImapResourceNode newResourceNode(Node node) throws AppClusterConfigurationException;
}
