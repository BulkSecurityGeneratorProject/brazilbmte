import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './tower-structure-info.reducer';
import { ITowerStructureInfo } from 'app/shared/model/tower-structure-info.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ITowerStructureInfoUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ITowerStructureInfoUpdateState {
  isNew: boolean;
}

export class TowerStructureInfoUpdate extends React.Component<ITowerStructureInfoUpdateProps, ITowerStructureInfoUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
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
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { towerStructureInfoEntity } = this.props;
      const entity = {
        ...towerStructureInfoEntity,
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
    this.props.history.push('/entity/tower-structure-info');
  };

  render() {
    const { towerStructureInfoEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="brazilbmteApp.towerStructureInfo.home.createOrEditLabel">
              <Translate contentKey="brazilbmteApp.towerStructureInfo.home.createOrEditLabel">
                Create or edit a TowerStructureInfo
              </Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : towerStructureInfoEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="tower-structure-info-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="folhaLabel" for="folha">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.folha">Folha</Translate>
                  </Label>
                  <AvField id="tower-structure-info-folha" type="string" className="form-control" name="folha" />
                </AvGroup>
                <AvGroup>
                  <Label id="sirgas2000XLabel" for="sirgas2000X">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000X">Sirgas 2000 X</Translate>
                  </Label>
                  <AvField id="tower-structure-info-sirgas2000X" type="string" className="form-control" name="sirgas2000X" />
                </AvGroup>
                <AvGroup>
                  <Label id="sirgas2000YLabel" for="sirgas2000Y">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000Y">Sirgas 2000 Y</Translate>
                  </Label>
                  <AvField id="tower-structure-info-sirgas2000Y" type="string" className="form-control" name="sirgas2000Y" />
                </AvGroup>
                <AvGroup>
                  <Label id="sirgas2000CotaLabel" for="sirgas2000Cota">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000Cota">Sirgas 2000 Cota</Translate>
                  </Label>
                  <AvField id="tower-structure-info-sirgas2000Cota" type="string" className="form-control" name="sirgas2000Cota" />
                </AvGroup>
                <AvGroup>
                  <Label id="condutorCotaLabel" for="condutorCota">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.condutorCota">Condutor Cota</Translate>
                  </Label>
                  <AvField id="tower-structure-info-condutorCota" type="string" className="form-control" name="condutorCota" />
                </AvGroup>
                <AvGroup>
                  <Label id="pontosTowerLabel" for="pontosTower">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.pontosTower">Pontos Tower</Translate>
                  </Label>
                  <AvField id="tower-structure-info-pontosTower" type="string" className="form-control" name="pontosTower" />
                </AvGroup>
                <AvGroup>
                  <Label id="utmCotaLabel" for="utmCota">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.utmCota">Utm Cota</Translate>
                  </Label>
                  <AvField id="tower-structure-info-utmCota" type="string" className="form-control" name="utmCota" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoALabel" for="infoA">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoA">Info A</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoA" type="text" name="infoA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoBLabel" for="infoB">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoB">Info B</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoB" type="text" name="infoB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoCLabel" for="infoC">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoC">Info C</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoC" type="text" name="infoC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDALabel" for="infoDA">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDA">Info DA</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoDA" type="text" name="infoDA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDBLabel" for="infoDB">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDB">Info DB</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoDB" type="text" name="infoDB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDCLabel" for="infoDC">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDC">Info DC</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoDC" type="text" name="infoDC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDDLabel" for="infoDD">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDD">Info DD</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoDD" type="text" name="infoDD" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoELabel" for="infoE">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoE">Info E</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoE" type="text" name="infoE" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoFLabel" for="infoF">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoF">Info F</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoF" type="text" name="infoF" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoGLabel" for="infoG">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoG">Info G</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoG" type="text" name="infoG" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoHALabel" for="infoHA">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHA">Info HA</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoHA" type="text" name="infoHA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoHBLabel" for="infoHB">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHB">Info HB</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoHB" type="text" name="infoHB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoHCLabel" for="infoHC">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHC">Info HC</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoHC" type="text" name="infoHC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIALabel" for="infoIA">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIA">Info IA</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoIA" type="text" name="infoIA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIBLabel" for="infoIB">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIB">Info IB</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoIB" type="text" name="infoIB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoICLabel" for="infoIC">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIC">Info IC</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoIC" type="text" name="infoIC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIDLabel" for="infoID">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoID">Info ID</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoID" type="text" name="infoID" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIELabel" for="infoIE">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIE">Info IE</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoIE" type="text" name="infoIE" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoJLabel" for="infoJ">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoJ">Info J</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoJ" type="text" name="infoJ" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKALabel" for="infoKA">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKA">Info KA</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoKA" type="text" name="infoKA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKBLabel" for="infoKB">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKB">Info KB</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoKB" type="text" name="infoKB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKCLabel" for="infoKC">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKC">Info KC</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoKC" type="text" name="infoKC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKDLabel" for="infoKD">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKD">Info KD</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoKD" type="text" name="infoKD" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKELabel" for="infoKE">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKE">Info KE</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoKE" type="text" name="infoKE" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKFLabel" for="infoKF">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKF">Info KF</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoKF" type="text" name="infoKF" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoLLabel" for="infoL">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoL">Info L</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoL" type="text" name="infoL" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoMLabel" for="infoM">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoM">Info M</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoM" type="text" name="infoM" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoNLabel" for="infoN">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoN">Info N</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoN" type="text" name="infoN" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoOALabel" for="infoOA">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoOA">Info OA</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoOA" type="text" name="infoOA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoOBLabel" for="infoOB">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoOB">Info OB</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoOB" type="text" name="infoOB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoPLabel" for="infoP">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoP">Info P</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoP" type="text" name="infoP" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoQLabel" for="infoQ">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoQ">Info Q</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoQ" type="text" name="infoQ" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoRLabel" for="infoR">
                    <Translate contentKey="brazilbmteApp.towerStructureInfo.infoR">Info R</Translate>
                  </Label>
                  <AvField id="tower-structure-info-infoR" type="text" name="infoR" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/tower-structure-info" replace color="info">
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
  towerStructureInfoEntity: storeState.towerStructureInfo.entity,
  loading: storeState.towerStructureInfo.loading,
  updating: storeState.towerStructureInfo.updating,
  updateSuccess: storeState.towerStructureInfo.updateSuccess
});

const mapDispatchToProps = {
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
)(TowerStructureInfoUpdate);
