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
import { IProject } from 'app/shared/model/project.model';
import { getEntities as getProjects } from 'app/entities/project/project.reducer';
import { getEntity, updateEntity, createEntity, reset } from './tender.reducer';
import { ITender } from 'app/shared/model/tender.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ITenderUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ITenderUpdateState {
  isNew: boolean;
  geometryJsonId: string;
  projectId: string;
}

export class TenderUpdate extends React.Component<ITenderUpdateProps, ITenderUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      geometryJsonId: '0',
      projectId: '0',
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
    this.props.getProjects();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { tenderEntity } = this.props;
      const entity = {
        ...tenderEntity,
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
    this.props.history.push('/entity/tender');
  };

  render() {
    const { tenderEntity, geometries, projects, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="brazilbmteApp.tender.home.createOrEditLabel">
              <Translate contentKey="brazilbmteApp.tender.home.createOrEditLabel">Create or edit a Tender</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : tenderEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="tender-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="tenderNameLabel" for="tenderName">
                    <Translate contentKey="brazilbmteApp.tender.tenderName">Tender Name</Translate>
                  </Label>
                  <AvField id="tender-tenderName" type="text" name="tenderName" />
                </AvGroup>
                <AvGroup>
                  <Label id="tenderLengthLabel" for="tenderLength">
                    <Translate contentKey="brazilbmteApp.tender.tenderLength">Tender Length</Translate>
                  </Label>
                  <AvField id="tender-tenderLength" type="text" name="tenderLength" />
                </AvGroup>
                <AvGroup>
                  <Label id="towerCountLabel" for="towerCount">
                    <Translate contentKey="brazilbmteApp.tender.towerCount">Tower Count</Translate>
                  </Label>
                  <AvField id="tender-towerCount" type="string" className="form-control" name="towerCount" />
                </AvGroup>
                <AvGroup>
                  <Label for="geometryJson.id">
                    <Translate contentKey="brazilbmteApp.tender.geometryJson">Geometry Json</Translate>
                  </Label>
                  <AvInput id="tender-geometryJson" type="select" className="form-control" name="geometryJson.id">
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
                <AvGroup>
                  <Label for="project.id">
                    <Translate contentKey="brazilbmteApp.tender.project">Project</Translate>
                  </Label>
                  <AvInput id="tender-project" type="select" className="form-control" name="project.id">
                    <option value="" key="0" />
                    {projects
                      ? projects.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/tender" replace color="info">
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
  projects: storeState.project.entities,
  tenderEntity: storeState.tender.entity,
  loading: storeState.tender.loading,
  updating: storeState.tender.updating,
  updateSuccess: storeState.tender.updateSuccess
});

const mapDispatchToProps = {
  getGeometries,
  getProjects,
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
)(TenderUpdate);
