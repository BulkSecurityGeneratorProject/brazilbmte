import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import TowerStructureInfo from './tower-structure-info';
import TowerStructureInfoDetail from './tower-structure-info-detail';
import TowerStructureInfoUpdate from './tower-structure-info-update';
import TowerStructureInfoDeleteDialog from './tower-structure-info-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={TowerStructureInfoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={TowerStructureInfoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={TowerStructureInfoDetail} />
      <ErrorBoundaryRoute path={match.url} component={TowerStructureInfo} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={TowerStructureInfoDeleteDialog} />
  </>
);

export default Routes;
