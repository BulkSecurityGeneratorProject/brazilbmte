import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './tower-temp.reducer';
import { ITowerTemp } from 'app/shared/model/tower-temp.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITowerTempDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class TowerTempDetail extends React.Component<ITowerTempDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { towerTempEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="brazilbmteApp.towerTemp.detail.title">TowerTemp</Translate> [<b>{towerTempEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="towerNumber">
                <Translate contentKey="brazilbmteApp.towerTemp.towerNumber">Tower Number</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.towerNumber}</dd>
            <dt>
              <span id="serialNumber">
                <Translate contentKey="brazilbmteApp.towerTemp.serialNumber">Serial Number</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.serialNumber}</dd>
            <dt>
              <span id="longitude">
                <Translate contentKey="brazilbmteApp.towerTemp.longitude">Longitude</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.longitude}</dd>
            <dt>
              <span id="latitude">
                <Translate contentKey="brazilbmteApp.towerTemp.latitude">Latitude</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.latitude}</dd>
            <dt>
              <span id="altitude">
                <Translate contentKey="brazilbmteApp.towerTemp.altitude">Altitude</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.altitude}</dd>
            <dt>
              <span id="utmX">
                <Translate contentKey="brazilbmteApp.towerTemp.utmX">Utm X</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.utmX}</dd>
            <dt>
              <span id="utmY">
                <Translate contentKey="brazilbmteApp.towerTemp.utmY">Utm Y</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.utmY}</dd>
            <dt>
              <span id="progressiveDistance">
                <Translate contentKey="brazilbmteApp.towerTemp.progressiveDistance">Progressive Distance</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.progressiveDistance}</dd>
            <dt>
              <span id="isCorner">
                <Translate contentKey="brazilbmteApp.towerTemp.isCorner">Is Corner</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.isCorner}</dd>
            <dt>
              <span id="corner">
                <Translate contentKey="brazilbmteApp.towerTemp.corner">Corner</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.corner}</dd>
            <dt>
              <span id="spanDistance">
                <Translate contentKey="brazilbmteApp.towerTemp.spanDistance">Span Distance</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.spanDistance}</dd>
            <dt>
              <span id="towerType">
                <Translate contentKey="brazilbmteApp.towerTemp.towerType">Tower Type</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.towerType}</dd>
            <dt>
              <span id="folha">
                <Translate contentKey="brazilbmteApp.towerTemp.folha">Folha</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.folha}</dd>
            <dt>
              <span id="sirgas2000X">
                <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000X">Sirgas 2000 X</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.sirgas2000X}</dd>
            <dt>
              <span id="sirgas2000Y">
                <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000Y">Sirgas 2000 Y</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.sirgas2000Y}</dd>
            <dt>
              <span id="sirgas2000Cota">
                <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000Cota">Sirgas 2000 Cota</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.sirgas2000Cota}</dd>
            <dt>
              <span id="condutorCota">
                <Translate contentKey="brazilbmteApp.towerTemp.condutorCota">Condutor Cota</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.condutorCota}</dd>
            <dt>
              <span id="pontosTower">
                <Translate contentKey="brazilbmteApp.towerTemp.pontosTower">Pontos Tower</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.pontosTower}</dd>
            <dt>
              <span id="utmCota">
                <Translate contentKey="brazilbmteApp.towerTemp.utmCota">Utm Cota</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.utmCota}</dd>
            <dt>
              <span id="infoA">
                <Translate contentKey="brazilbmteApp.towerTemp.infoA">Info A</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoA}</dd>
            <dt>
              <span id="infoB">
                <Translate contentKey="brazilbmteApp.towerTemp.infoB">Info B</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoB}</dd>
            <dt>
              <span id="infoC">
                <Translate contentKey="brazilbmteApp.towerTemp.infoC">Info C</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoC}</dd>
            <dt>
              <span id="infoDA">
                <Translate contentKey="brazilbmteApp.towerTemp.infoDA">Info DA</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoDA}</dd>
            <dt>
              <span id="infoDB">
                <Translate contentKey="brazilbmteApp.towerTemp.infoDB">Info DB</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoDB}</dd>
            <dt>
              <span id="infoDC">
                <Translate contentKey="brazilbmteApp.towerTemp.infoDC">Info DC</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoDC}</dd>
            <dt>
              <span id="infoDD">
                <Translate contentKey="brazilbmteApp.towerTemp.infoDD">Info DD</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoDD}</dd>
            <dt>
              <span id="infoE">
                <Translate contentKey="brazilbmteApp.towerTemp.infoE">Info E</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoE}</dd>
            <dt>
              <span id="infoF">
                <Translate contentKey="brazilbmteApp.towerTemp.infoF">Info F</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoF}</dd>
            <dt>
              <span id="infoG">
                <Translate contentKey="brazilbmteApp.towerTemp.infoG">Info G</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoG}</dd>
            <dt>
              <span id="infoHA">
                <Translate contentKey="brazilbmteApp.towerTemp.infoHA">Info HA</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoHA}</dd>
            <dt>
              <span id="infoHB">
                <Translate contentKey="brazilbmteApp.towerTemp.infoHB">Info HB</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoHB}</dd>
            <dt>
              <span id="infoHC">
                <Translate contentKey="brazilbmteApp.towerTemp.infoHC">Info HC</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoHC}</dd>
            <dt>
              <span id="infoIA">
                <Translate contentKey="brazilbmteApp.towerTemp.infoIA">Info IA</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoIA}</dd>
            <dt>
              <span id="infoIB">
                <Translate contentKey="brazilbmteApp.towerTemp.infoIB">Info IB</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoIB}</dd>
            <dt>
              <span id="infoIC">
                <Translate contentKey="brazilbmteApp.towerTemp.infoIC">Info IC</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoIC}</dd>
            <dt>
              <span id="infoID">
                <Translate contentKey="brazilbmteApp.towerTemp.infoID">Info ID</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoID}</dd>
            <dt>
              <span id="infoIE">
                <Translate contentKey="brazilbmteApp.towerTemp.infoIE">Info IE</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoIE}</dd>
            <dt>
              <span id="infoJ">
                <Translate contentKey="brazilbmteApp.towerTemp.infoJ">Info J</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoJ}</dd>
            <dt>
              <span id="infoKA">
                <Translate contentKey="brazilbmteApp.towerTemp.infoKA">Info KA</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoKA}</dd>
            <dt>
              <span id="infoKB">
                <Translate contentKey="brazilbmteApp.towerTemp.infoKB">Info KB</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoKB}</dd>
            <dt>
              <span id="infoKC">
                <Translate contentKey="brazilbmteApp.towerTemp.infoKC">Info KC</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoKC}</dd>
            <dt>
              <span id="infoKD">
                <Translate contentKey="brazilbmteApp.towerTemp.infoKD">Info KD</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoKD}</dd>
            <dt>
              <span id="infoKE">
                <Translate contentKey="brazilbmteApp.towerTemp.infoKE">Info KE</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoKE}</dd>
            <dt>
              <span id="infoKF">
                <Translate contentKey="brazilbmteApp.towerTemp.infoKF">Info KF</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoKF}</dd>
            <dt>
              <span id="infoL">
                <Translate contentKey="brazilbmteApp.towerTemp.infoL">Info L</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoL}</dd>
            <dt>
              <span id="infoM">
                <Translate contentKey="brazilbmteApp.towerTemp.infoM">Info M</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoM}</dd>
            <dt>
              <span id="infoN">
                <Translate contentKey="brazilbmteApp.towerTemp.infoN">Info N</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoN}</dd>
            <dt>
              <span id="infoOA">
                <Translate contentKey="brazilbmteApp.towerTemp.infoOA">Info OA</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoOA}</dd>
            <dt>
              <span id="infoOB">
                <Translate contentKey="brazilbmteApp.towerTemp.infoOB">Info OB</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoOB}</dd>
            <dt>
              <span id="infoP">
                <Translate contentKey="brazilbmteApp.towerTemp.infoP">Info P</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoP}</dd>
            <dt>
              <span id="infoQ">
                <Translate contentKey="brazilbmteApp.towerTemp.infoQ">Info Q</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoQ}</dd>
            <dt>
              <span id="infoR">
                <Translate contentKey="brazilbmteApp.towerTemp.infoR">Info R</Translate>
              </span>
            </dt>
            <dd>{towerTempEntity.infoR}</dd>
          </dl>
          <Button tag={Link} to="/entity/tower-temp" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/tower-temp/${towerTempEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ towerTemp }: IRootState) => ({
  towerTempEntity: towerTemp.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TowerTempDetail);
