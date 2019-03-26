import React from 'react';
import { Switch } from 'react-router-dom';

// tslint:disable-next-line:no-unused-variable
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Project from './project';
import Tender from './tender';
import Tower from './tower';
import Geometry from './geometry';
import TowerStructureInfo from './tower-structure-info';
import TowerTemp from './tower-temp';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}/project`} component={Project} />
      <ErrorBoundaryRoute path={`${match.url}/tender`} component={Tender} />
      <ErrorBoundaryRoute path={`${match.url}/tower`} component={Tower} />
      <ErrorBoundaryRoute path={`${match.url}/geometry`} component={Geometry} />
      <ErrorBoundaryRoute path={`${match.url}/tower-structure-info`} component={TowerStructureInfo} />
      <ErrorBoundaryRoute path={`${match.url}/tower-temp`} component={TowerTemp} />
      {/* jhipster-needle-add-route-path - JHipster will routes here */}
    </Switch>
  </div>
);

export default Routes;
