import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import OverheadLine from './overhead-line';
import OverheadLineDetail from './overhead-line-detail';
import OverheadLineUpdate from './overhead-line-update';
import OverheadLineDeleteDialog from './overhead-line-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={OverheadLineUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={OverheadLineUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={OverheadLineDetail} />
      <ErrorBoundaryRoute path={match.url} component={OverheadLine} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={OverheadLineDeleteDialog} />
  </>
);

export default Routes;
