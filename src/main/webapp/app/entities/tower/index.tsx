import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Tower from './tower';
import TowerDetail from './tower-detail';
import TowerUpdate from './tower-update';
import TowerDeleteDialog from './tower-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={TowerUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={TowerUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={TowerDetail} />
      <ErrorBoundaryRoute path={match.url} component={Tower} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={TowerDeleteDialog} />
  </>
);

export default Routes;
