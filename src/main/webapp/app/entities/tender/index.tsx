import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Tender from './tender';
import TenderDetail from './tender-detail';
import TenderUpdate from './tender-update';
import TenderDeleteDialog from './tender-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={TenderUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={TenderUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={TenderDetail} />
      <ErrorBoundaryRoute path={match.url} component={Tender} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={TenderDeleteDialog} />
  </>
);

export default Routes;
