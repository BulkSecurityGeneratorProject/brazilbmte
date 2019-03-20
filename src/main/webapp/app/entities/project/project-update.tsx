import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IGeometry } from 'app/shared/model/geometry.model';
import { getEntities as getGeometries } from 'app/entities/geometry/geometry.reducer';
import { getEntity, updateEntity, createEntity, reset } from './project.reducer';
import { IProject } from 'app/shared/model/project.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IProjectUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IProjectUpdateState {
  isNew: boolean;
  geometryJsonId: string;
}

export class ProjectUpdate extends React.Component<IProjectUpdateProps, IProjectUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      geometryJsonId: '0',
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }

    this.props.getGeometries();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { projectEntity } = this.props;
      const entity = {
        ...projectEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/project');
  };

  render() {
    const { projectEntity, geometries, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="brazilbmteApp.project.home.createOrEditLabel">
              <Translate contentKey="brazilbmteApp.project.home.createOrEditLabel">Create or edit a Project</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : projectEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="project-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="projectNameLabel" for="projectName">
                    <Translate contentKey="brazilbmteApp.project.projectName">Project Name</Translate>
                  </Label>
                  <AvField id="project-projectName" type="text" name="projectName" />
                </AvGroup>
                <AvGroup>
                  <Label id="voltageLabel" for="voltage">
                    <Translate contentKey="brazilbmteApp.project.voltage">Voltage</Translate>
                  </Label>
                  <AvField id="project-voltage" type="text" name="voltage" />
                </AvGroup>
                <AvGroup>
                  <Label id="descriptionLabel" for="description">
                    <Translate contentKey="brazilbmteApp.project.description">Description</Translate>
                  </Label>
                  <AvField id="project-description" type="text" name="description" />
                </AvGroup>
                <AvGroup>
                  <Label id="projectLengthLabel" for="projectLength">
                    <Translate contentKey="brazilbmteApp.project.projectLength">Project Length</Translate>
                  </Label>
                  <AvField id="project-projectLength" type="text" name="projectLength" />
                </AvGroup>
                <AvGroup>
                  <Label id="towerCountLabel" for="towerCount">
                    <Translate contentKey="brazilbmteApp.project.towerCount">Tower Count</Translate>
                  </Label>
                  <AvField id="project-towerCount" type="string" className="form-control" name="towerCount" />
                </AvGroup>
                <AvGroup>
                  <Label for="geometryJson.id">
                    <Translate contentKey="brazilbmteApp.project.geometryJson">Geometry Json</Translate>
                  </Label>
                  <AvInput id="project-geometryJson" type="select" className="form-control" name="geometryJson.id">
                    <option value="" key="0" />
                    {geometries
                      ? geometries.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/project" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />&nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />&nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  geometries: storeState.geometry.entities,
  projectEntity: storeState.project.entity,
  loading: storeState.project.loading,
  updating: storeState.project.updating,
  updateSuccess: storeState.project.updateSuccess
});

const mapDispatchToProps = {
  getGeometries,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ProjectUpdate);
