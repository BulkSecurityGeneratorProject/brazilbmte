import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import TowerTemp from './tower-temp';
import TowerTempDetail from './tower-temp-detail';
import TowerTempUpdate from './tower-temp-update';
import TowerTempDeleteDialog from './tower-temp-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={TowerTempUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={TowerTempUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={TowerTempDetail} />
      <ErrorBoundaryRoute path={match.url} component={TowerTemp} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={TowerTempDeleteDialog} />
  </>
);

export default Routes;
