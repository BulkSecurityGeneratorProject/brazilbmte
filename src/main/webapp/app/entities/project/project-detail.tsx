import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './project.reducer';
import { IProject } from 'app/shared/model/project.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IProjectDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class ProjectDetail extends React.Component<IProjectDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { projectEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="brazilbmteApp.project.detail.title">Project</Translate> [<b>{projectEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="projectName">
                <Translate contentKey="brazilbmteApp.project.projectName">Project Name</Translate>
              </span>
            </dt>
            <dd>{projectEntity.projectName}</dd>
            <dt>
              <span id="voltage">
                <Translate contentKey="brazilbmteApp.project.voltage">Voltage</Translate>
              </span>
            </dt>
            <dd>{projectEntity.voltage}</dd>
            <dt>
              <span id="description">
                <Translate contentKey="brazilbmteApp.project.description">Description</Translate>
              </span>
            </dt>
            <dd>{projectEntity.description}</dd>
            <dt>
              <span id="projectLength">
                <Translate contentKey="brazilbmteApp.project.projectLength">Project Length</Translate>
              </span>
            </dt>
            <dd>{projectEntity.projectLength}</dd>
            <dt>
              <span id="towerCount">
                <Translate contentKey="brazilbmteApp.project.towerCount">Tower Count</Translate>
              </span>
            </dt>
            <dd>{projectEntity.towerCount}</dd>
            <dt>
              <Translate contentKey="brazilbmteApp.project.geometryJson">Geometry Json</Translate>
            </dt>
            <dd>{projectEntity.geometryJson ? projectEntity.geometryJson.id : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/project" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/project/${projectEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ project }: IRootState) => ({
  projectEntity: project.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ProjectDetail);
