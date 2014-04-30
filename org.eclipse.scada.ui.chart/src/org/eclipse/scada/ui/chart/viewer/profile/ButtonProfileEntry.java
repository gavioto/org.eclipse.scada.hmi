/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.profile;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.ui.chart.model.Profile;

public class ButtonProfileEntry extends ProfileEntry
{

    private final Button widget;

    public ButtonProfileEntry ( final DataBindingContext ctx, final Composite parent, final ProfileManager profileManager, final Profile profile, final ChartContext chartContext )
    {
        super ( ctx, profileManager, profile, chartContext );

        this.widget = new Button ( parent, SWT.TOGGLE );
        this.widget.setText ( profile.getLabel () );

        this.widget.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                fireSelection ( ButtonProfileEntry.this.widget.getSelection () );
            };
        } );
    }

    @Override
    public void activate ()
    {
        this.widget.setSelection ( true );
        this.widget.setEnabled ( false );

        super.activate ();
    }

    @Override
    public void deactivate ()
    {
        this.widget.setSelection ( false );
        this.widget.setEnabled ( true );

        super.deactivate ();
    }

}
