import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Geometry from './geometry';
import GeometryDetail from './geometry-detail';
import GeometryUpdate from './geometry-update';
import GeometryDeleteDialog from './geometry-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={GeometryUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={GeometryUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={GeometryDetail} />
      <ErrorBoundaryRoute path={match.url} component={Geometry} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={GeometryDeleteDialog} />
  </>
);

export default Routes;
